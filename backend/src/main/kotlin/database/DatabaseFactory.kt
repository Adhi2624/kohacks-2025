package com.payir.database

import com.payir.models.*
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {
    fun init() {
        val config = HikariConfig().apply {
            driverClassName = System.getenv("DATABASE_DRIVER") ?: "org.postgresql.Driver"
            jdbcUrl = System.getenv("DATABASE_URL") ?: "jdbc:postgresql://neondb_owner:npg_rwP7WC3JTbMo@ep-rough-mud-a101bqoc-pooler.ap-southeast-1.aws.neon.tech/kotlinHackathon?sslmode=require&channel_binding=require"
            maximumPoolSize = 10
            isAutoCommit = false
        }
        
        val dataSource = HikariDataSource(config)
        Database.connect(dataSource)
        
        // Create tables (in production, use Flyway migrations instead)
        transaction {
            SchemaUtils.createMissingTablesAndColumns(
                Users,
                Farmers,
                CropPlantings,
                FarmerDocuments,
                Admin,
                AgriDeptPersonnel,
                Districts,
                Taluks,
                Villages,
                Facilities,
                FacilitiesHistory,
                Bookings,
                BookingsHistory,
                StorageRecords,
                StorageRecordsHistory,
                SeedMetadata,
                DeviceSyncState
            )
        }
    }
}

