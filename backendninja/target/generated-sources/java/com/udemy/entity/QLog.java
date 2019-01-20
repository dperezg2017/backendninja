package com.udemy.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLog is a Querydsl query type for Log
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLog extends EntityPathBase<Log> {

    private static final long serialVersionUID = -665041678L;

    public static final QLog log = new QLog("log");

    public final DateTimePath<java.util.Date> date = createDateTime("date", java.util.Date.class);

    public final StringPath details = createString("details");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath url = createString("url");

    public final StringPath username = createString("username");

    public QLog(String variable) {
        super(Log.class, forVariable(variable));
    }

    public QLog(Path<? extends Log> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLog(PathMetadata metadata) {
        super(Log.class, metadata);
    }

}

