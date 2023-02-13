package com.fse0.microservice.pensionerdetail.dto;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PensionerResponseBody<T> {

    T content;
    String error_msg;
}