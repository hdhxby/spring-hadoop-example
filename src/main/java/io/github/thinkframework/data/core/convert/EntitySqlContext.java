package io.github.thinkframework.data.core.convert;

import org.springframework.data.relational.core.mapping.PersistentPropertyPathExtension;
import org.springframework.data.relational.core.mapping.RelationalPersistentEntity;
import org.springframework.data.relational.core.sql.Column;
import org.springframework.data.relational.core.sql.SqlIdentifier;
import org.springframework.data.relational.core.sql.Table;

/**
 * @see org.springframework.data.jdbc.core.convert.SqlContext
 */
public class EntitySqlContext {

    private final RelationalPersistentEntity<?> entity;
    private final Table table;

    EntitySqlContext(RelationalPersistentEntity<?> entity) {

        this.entity = entity;
        this.table = Table.create(entity.getTableName());
    }

    Column getIdColumn() {
        return table.column(entity.getIdColumn());
    }

    Column getVersionColumn() {
        return table.column(entity.getRequiredVersionProperty().getColumnName());
    }

    Table getTable() {
        return table;
    }

    Table getTable(PersistentPropertyPathExtension path) {

        SqlIdentifier tableAlias = path.getTableAlias();
        Table table = Table.create(path.getTableName());
        return tableAlias == null ? table : table.as(tableAlias);
    }

    Column getColumn(PersistentPropertyPathExtension path) {
        return getTable(path).column(path.getColumnName()).as(path.getColumnAlias());
    }

    Column getReverseColumn(PersistentPropertyPathExtension path) {
        return getTable(path).column(path.getReverseColumnName()).as(path.getReverseColumnNameAlias());
    }
}
