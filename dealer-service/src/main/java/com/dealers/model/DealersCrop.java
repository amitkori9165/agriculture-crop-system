package com.dealers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DealersCrop {

//	@Id
//	@Column(name = "CROP_ID")
//	@Positive(message = "ID must be positive")
//	@NotNull(message = "ID cannot be left blank...")
	private int cropId;

//	@Column(name = "CROP_NAME")
//	@NotBlank(message = "Name cannot be left blank...")
//	@Size(min = 2, message = "Name should be more than 2 letters...") 
	private String cropName;

//	@Column(name = "CROP_QUANTITY")
//	@Positive(message = "Quantity must be positive")
	private int cropQuantity;

//	@Column(name = "CROP_PRICE")
//	@Positive(message = "Crop price must be positive")
	private double cropPrice;

//	@Column(name = "FARMER_ID")
	private int farmerId;
	
//	@NotBlank(message = "Crop status cannot be left blank")
	private String cropStatus;
	
	private Integer dealerId;
	private Integer bookingId;

//	public int getCropId() {
//		return cropId;
//	}
//
//	public void setCropId(int cropId) {
//		this.cropId = cropId;
//	}
//
//	public String getCropName() {
//		return cropName;
//	}
//
//	public void setCropName(String cropName) {
//		this.cropName = cropName;
//	}
//
//	public String getCropQuantity() {
//		return cropQuantity;
//	}
//
//	public void setCropQuantity(String cropQuantity) {
//		this.cropQuantity = cropQuantity;
//	}
//
//	public double getCropPrice() {
//		return cropPrice;
//	}
//
//	public void setCropPrice(double cropPrice) {
//		this.cropPrice = cropPrice;
//	}
//
//	public int getFarmerId() {
//		return farmerId;
//	}
//
//	public void setFarmerId(int farmerId2) {
//		this.farmerId = farmerId2;
//	}
//
////	public Crop(@Positive(message = "ID must be positive") @NotNull(message = "ID cannot be left blank...") int cropId,
////			@NotBlank(message = "Name cannot be left blank...") @Size(min = 2, message = "Name should be more than 2 letters...") String cropName,
////			@Positive(message = "Quantity must be positive") String cropQuantity,
////			@Positive(message = "Crop price must be positive") double cropPrice, int farmerId) {
////		super();
////		this.cropId = cropId;
////		this.cropName = cropName;
////		this.cropQuantity = cropQuantity;
////		this.cropPrice = cropPrice;
////		this.farmerId = farmerId;
////	}
//	public DealersCrop(int cropId,String cropName,String cropQuantity, double cropPrice,int farmerId) {
//		super();
//		this.cropId = cropId;
//		this.cropName = cropName;
//		this.cropQuantity = cropQuantity;
//		this.cropPrice = cropPrice;
//		this.farmerId = farmerId;		
//	}
//
//	public DealersCrop() {
//
//	}
}
