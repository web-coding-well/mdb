package com.junmeng.mdb.entity.secondary

/**
 * Created by hwj on 2017/7/10.
 */
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * @author 程序猿DD
 * *
 * @version 1.0.0
 * *
 * @date 16/3/21 下午3:35.
 * *
 * @blog http://blog.didispace.com
 */
@Entity
data class Message(
        @Id
        @GeneratedValue
        var id: Long? = null,

        @Column(nullable = false)
        var name: String? = null,

        @Column(nullable = false)
        var content: String? = null
)