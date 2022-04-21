package com.lhh.seamanrecruit.entity;


import com.lhh.seamanrecruit.config.Table;
import lombok.Data;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;

/**
 * <p>简历明细实体类</p>
 * @author yslong
 * @date 2022-04-12 14:10:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("简历明细")
@TableName(value = "resume_details")
@Table(tableName = "resume_details",keyFields = "id")
public class ResumeDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */

	@Id
	@ApiModelProperty(value = "主键id")
	@Column(name = "id")
	private Long id;

	/**
	 * 起始-结束
	 */
	@ApiModelProperty(value = "起始-结束")
	@Column(name = "start_end")
	private String startEnd;

	/**
	 * 担任职务
	 */
	@ApiModelProperty(value = "担任职务")
	@Column(name = "hold_position")
	private String holdPosition;

	/**
	 * 船名
	 */
	@ApiModelProperty(value = "船名")
	@Column(name = "ship_name")
	private String shipName;

	/**
	 * 船舶类型
	 */
	@ApiModelProperty(value = "船舶类型")
	@Column(name = "ship_type")
	private String shipType;

	/**
	 * 总吨/马力
	 */
	@ApiModelProperty(value = "总吨/马力")
	@Column(name = "gross_ton")
	private String grossTon;

	/**
	 * 航线
	 */
	@ApiModelProperty(value = "航线")
	@Column(name = "route")
	private String route;

	/**
	 * 所在公司
	 */
	@ApiModelProperty(value = "所在公司")
	@Column(name = "company")
	private String company;

	/**
	 * 主表id
	 */
	@ApiModelProperty(value = "主表id")
	@Column(name = "master_id")
	private Long masterId;



}
