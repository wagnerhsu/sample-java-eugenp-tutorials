package com.baeldung.mybatis.mapper;

import com.baeldung.mybatis.model.Address;
import com.baeldung.mybatis.model.Person;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Options.FlushCachePolicy;

public interface AddressMapper {

	@Insert("Insert into address (streetAddress,personId) values(#{streetAddress},#{personId})")
	@Options(useGeneratedKeys = true, flushCache = FlushCachePolicy.DEFAULT)
	public Integer saveAddress(Address address);

	@Select("SELECT addressId, streetAddress FROM Address WHERE addressId = #{addressId}")
	@Results(value = { @Result(property = "addressId", column = "addressId"),
			@Result(property = "streetAddress", column = "streetAddress"),
			@Result(property = "person", column = "personId", javaType = Person.class, one = @One(select = "getPerson")) })
	Address getAddresses(Integer addressId);

	@Select("SELECT personId FROM address WHERE addressId = #{addressId})")
	Person getPerson(Integer addressId);
}
