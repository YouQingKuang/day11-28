package com.example.autoconfig.domain;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Component("getPer")
public class Person implements Serializable {
	private static final long serialVersionUID = 4464233896798170487L;
	private String name;
	private int age;
}
