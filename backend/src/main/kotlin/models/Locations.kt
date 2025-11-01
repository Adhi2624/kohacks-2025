package com.payir.models

import org.jetbrains.exposed.sql.Table

object Districts : Table("districts") {
    val id = uuid("id").primaryKey().defaultExpression(org.jetbrains.exposed.sql.SqlExpressionBuilder.wrap("gen_random_uuid()"))
    val name = text("name").uniqueIndex()
    val state = text("state").nullable()
    val code = text("code").uniqueIndex().nullable()
}

object Taluks : Table("taluks") {
    val id = uuid("id").primaryKey().defaultExpression(org.jetbrains.exposed.sql.SqlExpressionBuilder.wrap("gen_random_uuid()"))
    val districtId = uuid("district_id").references(Districts.id)
    val name = text("name")
    val code = text("code").uniqueIndex().nullable()
}

object Villages : Table("villages") {
    val id = uuid("id").primaryKey().defaultExpression(org.jetbrains.exposed.sql.SqlExpressionBuilder.wrap("gen_random_uuid()"))
    val talukId = uuid("taluk_id").references(Taluks.id)
    val name = text("name")
    val code = text("code").uniqueIndex().nullable()
}

