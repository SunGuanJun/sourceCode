/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.commons.pool;

/**
 * A base implementation of <code>KeyedPoolableObjectFactory</code>.
 * <p>
 * All operations defined here are essentially no-op's.
 * </p>
 *
 * @param <K> the type of keys in this pool
 * @param <V> the type of objects held in this pool
 * 
 * @see KeyedPoolableObjectFactory
 *
 * @author Rodney Waldhoff
 * @version $Revision: 1222388 $ $Date: 2011-12-22 13:28:27 -0500 (Thu, 22 Dec 2011) $
 * @since Pool 1.0
 */
/**
 * KeyedPoolableObjectFactory接口的一个基本实现
 * 这里定义的操作基本上都是空操作
 * @author hzsunguanjun
 *
 * @param <K>
 * @param <V>
 */
public abstract class BaseKeyedPoolableObjectFactory<K, V> implements KeyedPoolableObjectFactory<K, V> {
    /**
     * Create an instance that can be served by the pool.
     *
     * @param key the key used when constructing the object
     * @return an instance that can be served by the pool
     */
	/**
	 * 创建一个对象池可用的实例
	 */
    public abstract V makeObject(K key)
        throws Exception;

    /**
     * Destroy an instance no longer needed by the pool.
     * <p>
     * The default implementation is a no-op.
     * </p>
     *
     * @param key the key used when selecting the instance
     * @param obj the instance to be destroyed
     */
    /**
     * 销毁一个不再被对象池需要的实例
     * 默认实现是一个空操作
     * ps：java中一般不会手动释放内存，如果需要销毁对象的话，应该只需要把引用置为空就行了吧
     */
    public void destroyObject(K key, V obj)
        throws Exception {
    }

    /**
     * Ensures that the instance is safe to be returned by the pool.
     * <p>
     * The default implementation always returns <tt>true</tt>.
     * </p>
     *
     * @param key the key used when selecting the object
     * @param obj the instance to be validated
     * @return always <code>true</code> in the default implementation
     */ 
    /**
     * 确保实例可以安全地返回对象池
     * 默认实现永远返回true
     * ps：这个方法一般是什么被调用？实例使用完返还对象池的时候调用吗？
     */
    public boolean validateObject(K key, V obj) {
        return true;
    }

    /**
     * Reinitialize an instance to be returned by the pool.
     * <p>
     * The default implementation is a no-op.
     * </p>
     *
     * @param key the key used when selecting the object
     * @param obj the instance to be activated
     */
    /**
     * 重新初始化一个返还对象池的实例
     * 默认实现是一个空操作
     */
    public void activateObject(K key, V obj)
        throws Exception {
    }

    /**
     * Uninitialize an instance to be returned to the idle object pool.
     * <p>
     * The default implementation is a no-op.
     * </p>
     *
     * @param key the key used when selecting the object
     * @param obj the instance to be passivated
     */
    /**
     * 卸载一个被返还空闲对象池的实例
     * 默认实现是一个空操作
     * ps：这样做的目的是什么呢？uninitialize应该是指释放资源。应该是为了节省资源吧，有些对象池是有最高负载的
     */
    public void passivateObject(K key, V obj)
        throws Exception {
    }
}
