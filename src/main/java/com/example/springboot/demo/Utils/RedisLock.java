package com.example.springboot.demo.Utils;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.Collections;

@Component
public class RedisLock {
    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    /**
     * 尝试获取分布式锁
     *
     * @param jedis      Redis客户端
     * @param lockKey    锁
     * @param requestId  请求标识
     * @param expireTime 超期时间
     * @return 是否获取成功
     */
    public static boolean tryGetDistributedLock(Jedis jedis, String lockKey, String requestId, int expireTime) {
        String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
        return LOCK_SUCCESS.equals(result);
    }

    private static final Long RELEASE_SUCCESS = 1L;

    /**
     * 释放分布式锁
     *
     * @param jedis     Redis客户端
     * @param lockKey   锁
     * @param requestId 请求标识
     * @return 是否释放成功
     */
    public static boolean releaseDistributedLock(Jedis jedis, String lockKey, String requestId) {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));
        return RELEASE_SUCCESS.equals(result);

    }


//    private static Logger logger = LoggerFactory.getLogger(RedisLock.class);
//    private static final int DEFAULT_ACQUIRY_RESOLUTION_MILLIS = 100;
//    public static final String LOCK_PREFIX = "redis_lock_";
//
//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;
//
//    /**
//     * 锁超时时间，防止线程在入锁以后，无限的执行等待
//     */
//    private int expireMsecs = 60 * 1000;
//
//    /**
//     * 锁等待时间，防止线程饥饿
//     */
//    private int timeoutMsecs = 10 * 1000;
//
//
//    public String get(final String key) {
//        Object obj = null;
//        try {
//            obj = redisTemplate.execute((RedisCallback<Object>) connection -> {
//                StringRedisSerializer serializer = new StringRedisSerializer();
//                byte[] data = connection.get(serializer.serialize(key));
//                connection.close();
//                if (data == null) {
//                    return null;
//                }
//                return serializer.deserialize(data);
//            });
//        } catch (Exception e) {
//            logger.error("get redis error, key : {}", key);
//        }
//        return obj != null ? obj.toString() : null;
//    }
//
//    public boolean setNX(final String key, final String value) {
//        Object obj = null;
//        try {
//            obj = redisTemplate.execute((RedisCallback<Object>) connection -> {
//                StringRedisSerializer serializer = new StringRedisSerializer();
//                Boolean success = connection.setNX(serializer.serialize(key), serializer.serialize(value));
//                connection.close();
//                return success;
//            });
//        } catch (Exception e) {
//            logger.error("setNX redis error, key : {}", key);
//        }
//        return obj != null ? (Boolean) obj : false;
//    }
//
//    private String getSet(final String key, final String value) {
//        Object obj = null;
//        try {
//            obj = redisTemplate.execute((RedisCallback<Object>) connection -> {
//                StringRedisSerializer serializer = new StringRedisSerializer();
//                byte[] ret = connection.getSet(serializer.serialize(key), serializer.serialize(value));
//                connection.close();
//                return serializer.deserialize(ret);
//            });
//        } catch (Exception e) {
//            logger.error("setNX redis error, key : {}", key);
//        }
//        return obj != null ? (String) obj : null;
//    }
//
//    /**
//     * 获得 lock. 实现思路: 主要是使用了redis 的setnx命令,缓存了锁. reids缓存的key是锁的key,所有的共享,
//     * value是锁的到期时间(注意:这里把过期时间放在value了,没有时间上设置其超时时间) 执行过程:
//     * 1.通过setnx尝试设置某个key的值,成功(当前没有这个锁)则返回,成功获得锁
//     * 2.锁已经存在则获取锁的到期时间,和当前时间比较,超时的话,则设置新的值
//     *
//     * @return true if lock is acquired, false acquire timeouted
//     * @throws InterruptedException in case of thread interruption
//     */
//    public boolean lock(String lockKey) throws InterruptedException {
//        lockKey = LOCK_PREFIX + lockKey;
//        int timeout = timeoutMsecs;
//        while (timeout >= 0) {
//            long expires = System.currentTimeMillis() + expireMsecs + 1;
//            String expiresStr = String.valueOf(expires); // 锁到期时间
//            if (this.setNX(lockKey, expiresStr)) {
//                return true;
//            }
//
//            String currentValueStr = this.get(lockKey); // redis里的时间
//            if (currentValueStr != null && Long.parseLong(currentValueStr) < System.currentTimeMillis()) {
//                // 判断是否为空，不为空的情况下，如果被其他线程设置了值，则第二个条件判断是过不去的
//                // lock is expired
//
//                String oldValueStr = this.getSet(lockKey, expiresStr);
//                // 获取上一个锁到期时间，并设置现在的锁到期时间，
//                // 只有一个线程才能获取上一个线上的设置时间，因为jedis.getSet是同步的
//                if (oldValueStr != null && oldValueStr.equals(currentValueStr)) {
//                    // 防止误删（覆盖，因为key是相同的）了他人的锁——这里达不到效果，这里值会被覆盖，但是因为什么相差了很少的时间，所以可以接受
//
//                    // [分布式的情况下]:如过这个时候，多个线程恰好都到了这里，但是只有一个线程的设置值和当前值相同，他才有权利获取锁
//                    return true;
//                }
//            }
//            timeout -= DEFAULT_ACQUIRY_RESOLUTION_MILLIS;
//
//            /*
//             * 延迟100 毫秒, 这里使用随机时间可能会好一点,可以防止饥饿进程的出现,即,当同时到达多个进程,
//             * 只会有一个进程获得锁,其他的都用同样的频率进行尝试,后面有来了一些进行,也以同样的频率申请锁,这将可能导致前面来的锁得不到满足.
//             * 使用随机的等待时间可以一定程度上保证公平性
//             */
//            Thread.sleep(DEFAULT_ACQUIRY_RESOLUTION_MILLIS);
//
//        }
//        return false;
//    }
//
//    /**
//     * Acqurired lock release.
//     */
//    public void unlock(String lockKey) {
//        lockKey = LOCK_PREFIX + lockKey;
//        redisTemplate.delete(lockKey);
//    }

}