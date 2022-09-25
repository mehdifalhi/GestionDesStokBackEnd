package com.fali.Dto;

import com.fali.entites.MvtStk;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Builder
@Data
public class MvtStkDto {

	private Long idMvtStk;

	private Date dateMvt;

	private BigDecimal quantite;

	private int typeMvt;

	private ArticleDto article;

	public static MvtStkDto fromEntity(MvtStk mvtStk){
		if(mvtStk == null){
			return null;
		}

		return MvtStkDto.builder()
				.idMvtStk(mvtStk.getIdMvtStk())
				.dateMvt(mvtStk.getDateMvt())
				.quantite(mvtStk.getQuantite())
				.typeMvt(mvtStk.getTypeMvt())
				.article(ArticleDto.fromEntity(mvtStk.getArticle()))
				.build();
	}

	public static MvtStk toEntity(MvtStkDto mvtStkDto){
		if(mvtStkDto==null){
			return null;
		}
		MvtStk mvtStk =new MvtStk();

		mvtStk.setIdMvtStk(mvtStkDto.getIdMvtStk());
		mvtStk.setDateMvt(mvtStkDto.getDateMvt());
		mvtStk.setQuantite(mvtStkDto.getQuantite());
		mvtStk.setTypeMvt(mvtStkDto.getTypeMvt());
		mvtStk.setArticle(ArticleDto.toEntity(mvtStkDto.getArticle()));

		return mvtStk;
	}

	
	
}
