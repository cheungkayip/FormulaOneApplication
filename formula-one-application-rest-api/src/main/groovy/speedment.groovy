import com.speedment.config.parameters.*

name = "f1app";
packageLocation = "src/main/java";
packageName = "com.company.speedment.test";
enabled = true;
expanded = true;
dbms {
    ipAddress = "127.0.0.1";
    name = "db0";
    port = 3306;
    typeName = "MySQL";
    username = "root";
    enabled = true;
    expanded = true;
    schema {
        columnCompressionType = ColumnCompressionType.NONE;
        fieldStorageType = FieldStorageType.WRAPPER;
        name = "F1APP";
        schemaName = "F1APP";
        storageEngineType = StorageEngineType.ON_HEAP;
        defaultSchema = false;
        enabled = true;
        expanded = true;
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "ImagesDrivers";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "ImagesDrivers";
            enabled = true;
            expanded = false;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "driverImageId";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "driverDisplayImage";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "driverHelmet";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            primaryKeyColumn {
                name = "driverImageId";
                enabled = true;
                expanded = true;
            }
            index {
                name = "PRIMARY";
                enabled = true;
                expanded = true;
                unique = true;
                indexColumn {
                    name = "driverImageId";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
            }
        }
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "circuits";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "circuits";
            enabled = true;
            expanded = false;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "circuitId";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = true;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "circuitRef";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "name";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "location";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "country";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Float.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "lat";
                typeMapper = com.speedment.internal.core.config.mapper.identity.FloatIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Float.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "lng";
                typeMapper = com.speedment.internal.core.config.mapper.identity.FloatIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "alt";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "url";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            primaryKeyColumn {
                name = "circuitId";
                enabled = true;
                expanded = true;
            }
            index {
                name = "PRIMARY";
                enabled = true;
                expanded = true;
                unique = true;
                indexColumn {
                    name = "circuitId";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
            }
            index {
                name = "url";
                enabled = true;
                expanded = true;
                unique = true;
                indexColumn {
                    name = "url";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
            }
        }
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "constructorResults";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "constructorResults";
            enabled = true;
            expanded = false;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "constructorResultsId";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = true;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "raceId";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "constructorId";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Float.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "points";
                typeMapper = com.speedment.internal.core.config.mapper.identity.FloatIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "status";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            primaryKeyColumn {
                name = "constructorResultsId";
                enabled = true;
                expanded = true;
            }
            index {
                name = "PRIMARY";
                enabled = true;
                expanded = true;
                unique = true;
                indexColumn {
                    name = "constructorResultsId";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
            }
        }
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "constructorStandings";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "constructorStandings";
            enabled = true;
            expanded = false;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "constructorStandingsId";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = true;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "raceId";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "constructorId";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Float.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "points";
                typeMapper = com.speedment.internal.core.config.mapper.identity.FloatIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "position";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "positionText";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "wins";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            primaryKeyColumn {
                name = "constructorStandingsId";
                enabled = true;
                expanded = true;
            }
            index {
                name = "PRIMARY";
                enabled = true;
                expanded = true;
                unique = true;
                indexColumn {
                    name = "constructorStandingsId";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
            }
        }
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "constructors";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "constructors";
            enabled = true;
            expanded = false;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "constructorId";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = true;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "constructorRef";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "name";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "nationality";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "url";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            primaryKeyColumn {
                name = "constructorId";
                enabled = true;
                expanded = true;
            }
            index {
                name = "PRIMARY";
                enabled = true;
                expanded = true;
                unique = true;
                indexColumn {
                    name = "constructorId";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
            }
            index {
                name = "name";
                enabled = true;
                expanded = true;
                unique = true;
                indexColumn {
                    name = "name";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
            }
        }
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "driverStandings";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "driverStandings";
            enabled = true;
            expanded = false;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "driverStandingsId";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = true;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "raceId";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "driverId";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Float.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "points";
                typeMapper = com.speedment.internal.core.config.mapper.identity.FloatIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "position";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "positionText";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "wins";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            primaryKeyColumn {
                name = "driverStandingsId";
                enabled = true;
                expanded = true;
            }
            index {
                name = "PRIMARY";
                enabled = true;
                expanded = true;
                unique = true;
                indexColumn {
                    name = "driverStandingsId";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
            }
        }
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "drivers";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "drivers";
            enabled = true;
            expanded = false;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "driverId";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = true;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "driverRef";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "number";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "code";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "forename";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "surname";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.sql.Date.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "dob";
                typeMapper = com.speedment.internal.core.config.mapper.identity.DateIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "nationality";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "url";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            primaryKeyColumn {
                name = "driverId";
                enabled = true;
                expanded = true;
            }
            index {
                name = "PRIMARY";
                enabled = true;
                expanded = true;
                unique = true;
                indexColumn {
                    name = "driverId";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
            }
            index {
                name = "url";
                enabled = true;
                expanded = true;
                unique = true;
                indexColumn {
                    name = "url";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
            }
        }
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "lapTimes";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "lapTimes";
            enabled = true;
            expanded = false;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "raceId";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "driverId";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "lap";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "position";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "time";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "milliseconds";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            primaryKeyColumn {
                name = "raceId";
                enabled = true;
                expanded = true;
            }
            primaryKeyColumn {
                name = "driverId";
                enabled = true;
                expanded = true;
            }
            primaryKeyColumn {
                name = "lap";
                enabled = true;
                expanded = true;
            }
            index {
                name = "PRIMARY";
                enabled = true;
                expanded = true;
                unique = true;
                indexColumn {
                    name = "raceId";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
                indexColumn {
                    name = "driverId";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
                indexColumn {
                    name = "lap";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
            }
            index {
                name = "raceId";
                enabled = true;
                expanded = true;
                unique = false;
                indexColumn {
                    name = "raceId";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
            }
        }
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "pitStops";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "pitStops";
            enabled = true;
            expanded = false;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "raceId";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "driverId";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "stop";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "lap";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.sql.Time.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "time";
                typeMapper = com.speedment.internal.core.config.mapper.identity.TimeIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "duration";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "milliseconds";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            primaryKeyColumn {
                name = "raceId";
                enabled = true;
                expanded = true;
            }
            primaryKeyColumn {
                name = "driverId";
                enabled = true;
                expanded = true;
            }
            primaryKeyColumn {
                name = "stop";
                enabled = true;
                expanded = true;
            }
            index {
                name = "PRIMARY";
                enabled = true;
                expanded = true;
                unique = true;
                indexColumn {
                    name = "raceId";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
                indexColumn {
                    name = "driverId";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
                indexColumn {
                    name = "stop";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
            }
            index {
                name = "raceId";
                enabled = true;
                expanded = true;
                unique = false;
                indexColumn {
                    name = "raceId";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
            }
        }
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "qualifying";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "qualifying";
            enabled = true;
            expanded = false;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "qualifyId";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = true;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "raceId";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "driverId";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "constructorId";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "number";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "position";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "q1";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "q2";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "q3";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            primaryKeyColumn {
                name = "qualifyId";
                enabled = true;
                expanded = true;
            }
            index {
                name = "PRIMARY";
                enabled = true;
                expanded = true;
                unique = true;
                indexColumn {
                    name = "qualifyId";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
            }
        }
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "races";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "races";
            enabled = true;
            expanded = false;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "raceId";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = true;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "year";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "round";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "circuitId";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "name";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.sql.Date.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "date";
                typeMapper = com.speedment.internal.core.config.mapper.identity.DateIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.sql.Time.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "time";
                typeMapper = com.speedment.internal.core.config.mapper.identity.TimeIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "url";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            primaryKeyColumn {
                name = "raceId";
                enabled = true;
                expanded = true;
            }
            index {
                name = "PRIMARY";
                enabled = true;
                expanded = true;
                unique = true;
                indexColumn {
                    name = "raceId";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
            }
            index {
                name = "url";
                enabled = true;
                expanded = true;
                unique = true;
                indexColumn {
                    name = "url";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
            }
        }
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "results";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "results";
            enabled = true;
            expanded = false;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "resultId";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = true;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "raceId";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "driverId";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "constructorId";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "number";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "grid";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "position";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "positionText";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "positionOrder";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Float.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "points";
                typeMapper = com.speedment.internal.core.config.mapper.identity.FloatIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "laps";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "time";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "milliseconds";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "fastestLap";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "rank";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "fastestLapTime";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "fastestLapSpeed";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "statusId";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            primaryKeyColumn {
                name = "resultId";
                enabled = true;
                expanded = true;
            }
            index {
                name = "PRIMARY";
                enabled = true;
                expanded = true;
                unique = true;
                indexColumn {
                    name = "resultId";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
            }
        }
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "seasons";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "seasons";
            enabled = true;
            expanded = false;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "year";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "url";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            primaryKeyColumn {
                name = "year";
                enabled = true;
                expanded = true;
            }
            index {
                name = "PRIMARY";
                enabled = true;
                expanded = true;
                unique = true;
                indexColumn {
                    name = "year";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
            }
            index {
                name = "url";
                enabled = true;
                expanded = true;
                unique = true;
                indexColumn {
                    name = "url";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
            }
        }
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "status";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "status";
            enabled = true;
            expanded = false;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "statusId";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = true;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "status";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            primaryKeyColumn {
                name = "statusId";
                enabled = true;
                expanded = true;
            }
            index {
                name = "PRIMARY";
                enabled = true;
                expanded = true;
                unique = true;
                indexColumn {
                    name = "statusId";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
            }
        }
    }
}