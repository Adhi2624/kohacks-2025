package com.payir.models

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.date
import org.jetbrains.exposed.sql.javatime.timestamp

object Bookings : Table("bookings") {
    val id = uuid("id").primaryKey().defaultExpression(org.jetbrains.exposed.sql.SqlExpressionBuilder.wrap("gen_random_uuid()"))
    val farmerId = uuid("farmer_id").references(Farmers.id)
    val facilityId = uuid("facility_id").references(Facilities.id)
    val cropType = text("crop_type")
    val quantitySacks = integer("quantity_sacks")
    val status = text("status").default("PENDING") // PENDING, CONFIRMED, CANCELLED, COMPLETED
    val pricePerSack = decimal("price_per_sack", 10, 2).nullable()
    val priceTotal = decimal("price_total", 10, 2).nullable()
    val startDate = date("start_date")
    val endDate = date("end_date").nullable()
    val notes = text("notes").nullable()
    val createdAt = timestamp("created_at").defaultExpression(org.jetbrains.exposed.sql.SqlExpressionBuilder.currentTimestamp())
    val updatedAt = timestamp("updated_at").defaultExpression(org.jetbrains.exposed.sql.SqlExpressionBuilder.currentTimestamp())
    val createdBy = uuid("created_by").nullable().references(Users.id)
    val updatedBy = uuid("updated_by").nullable().references(Users.id)
}

object BookingsHistory : Table("bookings_history") {
    val id = uuid("id").primaryKey().defaultExpression(org.jetbrains.exposed.sql.SqlExpressionBuilder.wrap("gen_random_uuid()"))
    val bookingId = uuid("booking_id").references(Bookings.id)
    val action = text("action") // CREATED, UPDATED, STATUS_CHANGED, CANCELLED
    val oldStatus = text("old_status").nullable()
    val newStatus = text("new_status").nullable()
    val changedFields = text("changed_fields").nullable() // JSON stored as text
    val changedAt = timestamp("changed_at").defaultExpression(org.jetbrains.exposed.sql.SqlExpressionBuilder.currentTimestamp())
    val changedBy = uuid("changed_by").nullable().references(Users.id)
}

