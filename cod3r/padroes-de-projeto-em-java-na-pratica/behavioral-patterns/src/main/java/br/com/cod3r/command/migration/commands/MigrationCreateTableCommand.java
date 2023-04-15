package br.com.cod3r.command.migration.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public abstract class MigrationCreateTableCommand extends MigrationCommand{

    public MigrationCreateTableCommand(Map<String, List<String>> database) {
        super(database);
    }

    protected void createTable(String tableName, String... tableColumns) {
        List<String> columns = new ArrayList<>(Arrays.asList(tableColumns));
        database.put(tableName, columns);
    }

    protected void dropTable(String tableName) {
        database.remove(tableName);
    }
}
