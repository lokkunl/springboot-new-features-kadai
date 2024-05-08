package com.example.samuraitravel.form;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReviewForm {
	@NotNull(message = "評価点を選んでください。")
	@Range(min = 1, max = 5, message = "評価点は1から5点のいずれかにしてください")
	private Integer score;
	
	@NotBlank(message = "レビューを入力してください。")
	@Length(max = 300, message = "レビューは300文字以内にしてください")
	private String content;
}
