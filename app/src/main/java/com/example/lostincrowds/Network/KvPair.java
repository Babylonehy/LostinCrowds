/******************************************************************************
 * Copyright (c) 2019. Xiang Li From Australian National University CECS  All Rights Reserved. FileName: KvPair.java@author: jack@date: 18/05/19 12:21 AM@version: 1.0
 ******************************************************************************/

package com.example.lostincrowds.Network;

/**
 * The type Kv pair.
 *
 * @param <k> the type parameter
 * @param <v> the type parameter
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: Xiang Li
 * @Date: $date$ $time$
 */
public class KvPair<k,v> {


    private k key=null;
    private v value=null;

    /**
     * Instantiates a new Kv pair.
     *
     * @param key   the key
     * @param value the value
     */
    public KvPair ( k key , v value ) {
        this.key = key;
        this.value = value;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public v getValue () {
        return value;
    }

    /**
     * Gets key.
     *
     * @return the key
     */
    public k getKey () {
        return key;
    }

    @Override
    public String toString () {
        return "KvPair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
