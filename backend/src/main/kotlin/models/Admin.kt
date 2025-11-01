package com.payir.models

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.timestamp

object Admin : Table("admin") {
    val id = uuid("id").primaryKey().defaultExpression(org.jetbrains.exposed.sql.SqlExpressionBuilder.wrap("gen_random_uuid()"))
    val userId = uuid("user_id").uniqueIndex().references(Users.id)
    val name = text("name")
    val email = text("email").nullable()
    val phone = text("phone").nullable()
    val designation = text("designation").nullable()
    val department = text("department").nullable()
    val createdAt = timestamp("created_at").defaultExpression(org.jetbrains.exposed.sql.SqlExpressionBuilder.currentTimestamp())
    val updatedAt = timestamp("updated_at").defaultExpression(org.jetbrains.exposed.sql.SqlExpressionBuilder.currentTimestamp())
    val createdBy = uuid("created_by").nullable().references(Users.id)
    val updatedBy = uuid("updated_by").nullable().references(Users.id)
}

