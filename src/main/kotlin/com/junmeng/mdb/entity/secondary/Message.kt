package com.junmeng.mdb.entity.secondary

/**
 * Created by hwj on 2017/7/10.
 */
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id


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