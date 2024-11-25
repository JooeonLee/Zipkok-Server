package com.project.zipkok.dto;

import com.project.zipkok.common.enums.RealEstateType;
import com.project.zipkok.common.enums.TransactionType;
import com.project.zipkok.common.enums.ValidEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PatchOnBoardingRequest {

    @NotBlank
    @Size(max = 200)
    private String address;

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

    @NotNull
    @ValidEnum(enumClass = RealEstateType.class)
    private String realEstateType;

    @NotNull
    @ValidEnum(enumClass = TransactionType.class)
    private String transactionType;

    @NotNull
    @PositiveOrZero
    private Long mpriceMin;

    @NotNull
    @PositiveOrZero
    private Long mpriceMax;

    @NotNull
    @PositiveOrZero
    private Long mdepositMin;

    @NotNull
    @PositiveOrZero
    private Long mdepositMax;

    @NotNull
    @PositiveOrZero
    private Long ydepositMin;

    @NotNull
    @PositiveOrZero
    private Long ydepositMax;

    @NotNull
    @PositiveOrZero
    private Long purchaseMin;

    @NotNull
    @PositiveOrZero
    private Long purchaseMax;

    @AssertTrue(message = "최소가격은 최대가격을 넘을 수 없습니다.")
    private boolean isSmallerthanMax(){
        return
                this.mpriceMax >= this.mpriceMin &&
                this.mdepositMax >= this.mdepositMin &&
                this.ydepositMax >= this.ydepositMin &&
                this.purchaseMax >= this.purchaseMin;
    }
}
