package com.ashukhard.dto;

import lombok.Data;

import com.ashukhard.model.Address;
import com.ashukhard.model.AddressType;

/**
 * The DTO for {@link Address}
 * 
 * @author ashutosh
 */
@Data
public class AddressDTO {

	private long id;

	private String name;

	private AddressType type;

}
