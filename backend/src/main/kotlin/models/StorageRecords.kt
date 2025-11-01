package com.payir.models

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.date
import org.jetbrains.exposed.sql.javatime.timestamp

object StorageRecords : Table("storage_records") {
    val id = uuid("id").primaryKey().defaultExpression(org.jetbrains.exposed.sql.SqlExpressionBuilder.wrap("gen_random_uuid()"))
    val farmerId = uuid("farmer_id").references(Farmers.id)
    val bookingId = uuid("booking_id").nullable().references(Bookings.id)
    val cropType = text("crop_type")
    val quantitySacks = integer("quantity_sacks")
    val storageType = text("storage_type").nullable() // HDPE_BAGS, SILO, etc.
    val moisturePercent = decimal("moisture_percent", 5, 2).nullable()
    val storageLocationDesc = text("storage_location_desc").nullable()
    val facilityId = uuid("facility_id").nullable().references(Facilities.id)
    val storedDate = date("stored_date").nullable()
    val createdAt = timestamp("created_at").defaultExpression(org.jetbrains.exposed.sql.SqlExpressionBuilder.currentTimestamp())
    val updatedAt = timestamp("updated_at").defaultExpression(org.jetbrains.exposed.sql.SqlExpressionBuilder.currentTimestamp())
    val createdBy = uuid("created_by").nullable().references(Users.id)
    val updatedBy = uuid("updated_by").nullable().references(Users.id)
}

object StorageRecordsHistory : Table("storage_records_history") {
    val id = uuid("id").primaryKey().defaultExpression(org.jetbrains.exposed.sql.SqlExpressionBuilder.wrap("gen_random_uuid()"))
    val storageRecordId = uuid("storage_record_id").references(StorageRecords.id)
    val action = text("action") // CREATED, UPDATED, DELETED
    val changedFields = text("changed_fields").nullable() // JSON stored as text
    val oldValues = text("old_values").nullable() // JSON stored as text
    val newValues = text("new_values").nullable() // JSON stored as text
    val changedAt = timestamp("changed_at").defaultExpression(org.jetbrains.exposed.sql.SqlExpressionBuilder.currentTimestamp())
    val changedBy = uuid("changed_by").nullable().references(Users.id)
}

