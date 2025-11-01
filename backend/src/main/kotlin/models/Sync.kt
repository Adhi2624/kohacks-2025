package com.payir.models

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.timestamp

object SeedMetadata : Table("seed_metadata") {
    val id = uuid("id").primaryKey().defaultExpression(org.jetbrains.exposed.sql.SqlExpressionBuilder.wrap("gen_random_uuid()"))
    val version = integer("version").uniqueIndex()
    val createdAt = timestamp("created_at").defaultExpression(org.jetbrains.exposed.sql.SqlExpressionBuilder.currentTimestamp())
}

object DeviceSyncState : Table("device_sync_state") {
    val id = uuid("id").primaryKey().defaultExpression(org.jetbrains.exposed.sql.SqlExpressionBuilder.wrap("gen_random_uuid()"))
    val userId = uuid("user_id").references(Users.id)
    val deviceId = text("device_id")
    val lastSyncAt = timestamp("last_sync_at").nullable()
    val lastSeedVersion = integer("last_seed_version").nullable()
}

