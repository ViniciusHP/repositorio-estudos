package br.com.cod3r.command.migration.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserTable extends MigrationCreateTableCommand{

    public UserTable(Map<String, List<String>> database) {
        super(database);
    }

    @Override
    public void execute() {
        createTable("USER", "ID", "NAME", "EMAIL", "PASSWORD");
    }

    @Override
    public void undo() {
        dropTable("USER");
    }
}
