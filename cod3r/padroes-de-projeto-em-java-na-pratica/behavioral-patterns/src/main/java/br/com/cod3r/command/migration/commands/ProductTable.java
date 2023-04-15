package br.com.cod3r.command.migration.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ProductTable extends MigrationCreateTableCommand{

    public ProductTable(Map<String, List<String>> database) {
        super(database);
    }

    @Override
    public void execute() {
        createTable("PRODUCT", "ID", "DESCRIPTION", "PRICE");
    }

    @Override
    public void undo() {
        dropTable("PRODUCT");
    }
}
