package br.com.cod3r.command.migration.commands;

import java.util.List;
import java.util.Map;

public class UserTableRoleColumn extends MigrationCommand {

    public UserTableRoleColumn(Map<String, List<String>> database) {
        super(database);
    }

    @Override
    public void execute() {
        database.get("USER").add("ROLE");
    }

    @Override
    public void undo() {
        database.get("USER").remove("ROLE");
    }
}
