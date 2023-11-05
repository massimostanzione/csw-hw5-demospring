package it.uniroma2.sc.demospringhibernate.bean.mapping;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Interface for DTO Mappers.
 * Could be updated for more specific Bean/Entity conversion operations.
 * Also, ref. issue #4 (Java generics)
 * This is further extendable.
 *
 * @param <ENTITY>
 * @param <BEAN>
 */
@SuppressWarnings("unchecked") // casting handling
public class DTOMapper<ENTITY, BEAN extends Bean> {
    private final Type entityType;
    private final Type beanType;
    private ObjectMapper mapper = new ObjectMapper();

    public DTOMapper() {
        // get types @ runtime
        Type mySuperclass = this.getClass().getGenericSuperclass();
        entityType = ((ParameterizedType) mySuperclass).getActualTypeArguments()[0];
        beanType = ((ParameterizedType) mySuperclass).getActualTypeArguments()[1];
    }

    public ENTITY toEntity(BEAN b) {
        return (ENTITY) this.mapper.convertValue(b, entityType.getClass());
    }

    public List<ENTITY> toEntityList(List<BEAN> l) {
        List<ENTITY> ret = new ArrayList<>();
        for (BEAN b : l) {
            ret.add(this.toEntity(b));
        }
        return ret;
    }

    public BEAN toBean(ENTITY e) {
        ObjectMapper mapper = new ObjectMapper();
        return (BEAN) mapper.convertValue(e, beanType.getClass());
    }

    public List<BEAN> toBeanList(List<ENTITY> l) {
        List<BEAN> ret = new ArrayList<>();
        for (ENTITY e : l) {
            ret.add(this.toBean(e));
        }
        return ret;
    }

}
