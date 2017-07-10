package com.junmeng.mdb.repository.secondary

import com.junmeng.mdb.entity.secondary.Message
import org.springframework.data.jpa.repository.JpaRepository



/**
 * Created by hwj on 2017/7/10.
 */
interface MessageRepo : JpaRepository<Message, Long>{

}