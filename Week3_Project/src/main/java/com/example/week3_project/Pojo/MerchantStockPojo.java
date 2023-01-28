package com.example.week3_project.Pojo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
public class MerchantStockPojo {
    @NotEmpty
    @Size(max = 3)
    private String stock_id;

    @NotEmpty
    @Size(max = 3)
    private String productid;

    @NotEmpty
    @Size(max = 3)
    private String merchantid;


    @NotNull
    @Min(10)
    @Range(min = 10, max = 30000)
    private int stock;



}
