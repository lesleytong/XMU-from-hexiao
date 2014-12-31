package edu.ustb.sei.mde.morel.resource.morel.conversion;

import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.ustb.sei.mde.morel.BXRewritingRule;
import edu.ustb.sei.mde.morel.MorelFactory;
import edu.ustb.sei.mde.morel.Pattern;
import edu.ustb.sei.mde.morel.Rule;
import edu.ustb.sei.mde.morel.SectionType;
import edu.ustb.sei.mde.morel.TransformationModel;
import edu.ustb.sei.mde.morel.Unit;

public class TranslateBXRules {
	static public void translate(Unit unit, String forward, String backward) {
		
	}
	
	static public void translate(BXRewritingRule bxrule, TransformationModel forward, TransformationModel backward) {
		// forward
		// ��������ת������source����������view��when��update�Ӿ��еĵȺű��ʽ�ᱻת���ɸ�ֵ���ʽ��unmatchv��unmatchs�е����ݽ�������
		
		Rule fRule = MorelFactory.eINSTANCE.createRule();
		fRule.setName(bxrule.getName()+"_forward");
		fRule.setActive(bxrule.isActive());
		forward.getRules().add(fRule);
		
		Pattern lhs = EcoreUtil.copy(bxrule.getSource());
		lhs.setType(SectionType.LHS);
		
		Pattern rhs = MorelFactory.eINSTANCE.createPattern();
		rhs.setType(SectionType.RHS);
		rhs.getVariables().addAll(EcoreUtil.copyAll(lhs.getVariables()));
		
	}
	
	

}
