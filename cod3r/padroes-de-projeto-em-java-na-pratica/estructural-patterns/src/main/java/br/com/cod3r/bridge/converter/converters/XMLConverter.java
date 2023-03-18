package br.com.cod3r.bridge.converter.converters;

import br.com.cod3r.bridge.converter.employees.Employee;

public class XMLConverter implements Converter{
    @Override
    public String getEmployeeFormated(Employee emp) {
        StringBuilder sb = new StringBuilder();
        sb.append(createTag("employee", false))
                .append("\n\t")
                .append(createTag("name", false))
                .append(emp.getName())
                .append(createTag("name", true))
                .append("\n\t")
                .append(createTag("age", false))
                .append(emp.getAge())
                .append(createTag("age", true))
                .append("\n\t")
                .append(createTag("salary", false))
                .append(emp.getSalary())
                .append(createTag("salary", true))
                .append("\n")
                .append(createTag("employee", true));

        return sb.toString();
    }

    private String createTag(String tagName, boolean isCloseTag) {
        StringBuilder sb = new StringBuilder();
        String closeTagCharacter = isCloseTag ? "/" : "";
        return sb.append("<")
            .append(closeTagCharacter)
            .append(tagName)
            .append(">")
            .toString();
    }
}
