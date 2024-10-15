package com.humanmedi.miniproject.skill;

import com.humanmedi.miniproject.elemental.Elemental;

public class SkillAttack {
	private Elemental skill_type;
	
	public void setSkillType(Elemental elemental) {
		this.skill_type = elemental;
	}
	public Elemental getSkillType() {
		return this.skill_type;
	}
}
