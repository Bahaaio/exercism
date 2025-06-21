class Badge {
    public String print(Integer id, String name, String department) {
        var builder = new StringBuilder();

        if (id != null) {
            builder.append("[")
                    .append(id)
                    .append("] - ");
        }

        return builder
                .append(name)
                .append(" - ")
                .append(department == null ? "OWNER" : department.toUpperCase())
                .toString();
    }
}
