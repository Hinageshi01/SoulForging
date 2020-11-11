package hinageshi.soulforging.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * Made with Blockbench 3.7.2
 * Exported for Minecraft version 1.12
 */
public class ModelDementor extends ModelBase {
	private final ModelRenderer head;
	private final ModelRenderer tail;
	private final ModelRenderer tail_r1;
	private final ModelRenderer l4;
	private final ModelRenderer l3;
	private final ModelRenderer l2;
	private final ModelRenderer l1;
	private final ModelRenderer r4;
	private final ModelRenderer r3;
	private final ModelRenderer r2;
	private final ModelRenderer r1;
	private final ModelRenderer b5;
	private final ModelRenderer b4;
	private final ModelRenderer b3;
	private final ModelRenderer b2;
	private final ModelRenderer b1;

	public ModelDementor() {
		textureWidth = 64;
		textureHeight = 64;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 24.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 0, 0, 5.0F, -4.0F, -11.0F, 1, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 3, 3.0F, -3.0F, -11.0F, 1, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 21, 1.0F, -2.0F, -11.0F, 1, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 30, 21, -1.0F, -3.0F, -11.0F, 1, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 35, 0, -3.0F, -2.0F, -11.0F, 1, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 35, 3, -5.0F, -3.0F, -11.0F, 1, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 23, 39, -6.0F, -5.0F, -11.0F, 1, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 41, 12, -7.0F, -7.0F, -11.0F, 1, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 41, 15, -7.0F, -9.0F, -11.0F, 1, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 23, 42, 2.0F, -13.0F, -11.0F, 1, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 23, 45, 5.0F, -10.0F, -11.0F, 1, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 55, 55, 6.0F, -6.0F, -11.0F, 1, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 55, 52, 6.0F, -8.0F, -11.0F, 1, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 56, 4.0F, -12.0F, -11.0F, 1, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 5, 56, 0.0F, -12.0F, -11.0F, 1, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 10, 56, -2.0F, -13.0F, -11.0F, 1, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 25, 57, -4.0F, -12.0F, -11.0F, 1, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 30, 57, -6.0F, -11.0F, -11.0F, 1, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 0, -7.0F, -14.0F, -10.0F, 14, 14, 6, 0.0F, false));

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 24.0F, 0.0F);

		tail_r1 = new ModelRenderer(this);
		tail_r1.setRotationPoint(0.0F, -6.0F, 8.0F);
		tail.addChild(tail_r1);
		setRotationAngle(tail_r1, -1.0472F, 0.0F, 0.0F);
		tail_r1.cubeList.add(new ModelBox(tail_r1, 41, 12, -1.0F, -1.0F, 0.0F, 2, 2, 6, 0.0F, false));

		l4 = new ModelRenderer(this);
		l4.setRotationPoint(0.0F, 24.0F, 0.0F);
		l4.cubeList.add(new ModelBox(l4, 21, 49, 3.0F, 0.0F, 6.0F, 2, 2, 2, 0.0F, false));

		l3 = new ModelRenderer(this);
		l3.setRotationPoint(0.0F, 24.0F, 0.0F);
		l3.cubeList.add(new ModelBox(l3, 0, 51, 3.0F, 0.0F, 3.0F, 2, 2, 2, 0.0F, false));

		l2 = new ModelRenderer(this);
		l2.setRotationPoint(0.0F, 24.0F, 0.0F);
		l2.cubeList.add(new ModelBox(l2, 9, 51, 3.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F, false));

		l1 = new ModelRenderer(this);
		l1.setRotationPoint(5.0F, 24.0F, -2.0F);
		l1.cubeList.add(new ModelBox(l1, 28, 52, -2.0F, 0.0F, -1.0F, 2, 2, 2, 0.0F, false));

		r4 = new ModelRenderer(this);
		r4.setRotationPoint(0.0F, 24.0F, 0.0F);
		r4.cubeList.add(new ModelBox(r4, 37, 52, -5.0F, 0.0F, 6.0F, 2, 2, 2, 0.0F, false));

		r3 = new ModelRenderer(this);
		r3.setRotationPoint(0.0F, 24.0F, 0.0F);
		r3.cubeList.add(new ModelBox(r3, 46, 52, -5.0F, 0.0F, 3.0F, 2, 2, 2, 0.0F, false));

		r2 = new ModelRenderer(this);
		r2.setRotationPoint(0.0F, 24.0F, 0.0F);
		r2.cubeList.add(new ModelBox(r2, 52, 12, -5.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F, false));

		r1 = new ModelRenderer(this);
		r1.setRotationPoint(0.0F, 24.0F, 0.0F);
		r1.cubeList.add(new ModelBox(r1, 16, 54, -5.0F, 0.0F, -3.0F, 2, 2, 2, 0.0F, false));

		b5 = new ModelRenderer(this);
		b5.setRotationPoint(0.0F, 24.0F, 0.0F);
		b5.cubeList.add(new ModelBox(b5, 35, 21, -5.0F, -11.0F, 8.0F, 10, 10, 1, 0.0F, false));

		b4 = new ModelRenderer(this);
		b4.setRotationPoint(0.0F, 24.0F, 0.0F);
		b4.cubeList.add(new ModelBox(b4, 0, 21, -6.0F, -12.0F, 3.0F, 12, 12, 5, 0.0F, false));

		b3 = new ModelRenderer(this);
		b3.setRotationPoint(0.0F, 24.0F, 0.0F);
		b3.cubeList.add(new ModelBox(b3, 0, 39, -5.0F, -11.0F, 2.0F, 10, 10, 1, 0.0F, false));

		b2 = new ModelRenderer(this);
		b2.setRotationPoint(0.0F, 24.0F, 0.0F);
		b2.cubeList.add(new ModelBox(b2, 30, 34, -6.0F, -12.0F, -3.0F, 12, 12, 5, 0.0F, false));

		b1 = new ModelRenderer(this);
		b1.setRotationPoint(0.0F, 24.0F, 0.0F);
		b1.cubeList.add(new ModelBox(b1, 41, 0, -5.0F, -11.0F, -4.0F, 10, 10, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		head.render(f5);tail.render(f5);
		l4.render(f5);l3.render(f5);l2.render(f5);l1.render(f5);
		r4.render(f5);r3.render(f5);r2.render(f5);r1.render(f5);
		b5.render(f5);b4.render(f5);b3.render(f5);b2.render(f5);b1.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		final float A1=0.45F,A2=0.1F,w1=2.0F,w2=1.0F,pi=(float)Math.PI;
		//head.rotateAngleX = pi / 180 * headPitch;
		//head.rotateAngleY = pi / 180 * netHeadYaw;

		r1.rotateAngleX = A1 * MathHelper.cos(limbSwing * w1 + pi) * limbSwingAmount;
		r2.rotateAngleX = A1 * MathHelper.cos(limbSwing * w1 ) * limbSwingAmount;
		r3.rotateAngleX = A1 * MathHelper.cos(limbSwing * w1 + pi) * limbSwingAmount;
		r4.rotateAngleX = A1 * MathHelper.cos(limbSwing * w1 ) * limbSwingAmount;

		l1.rotateAngleX = A1 * MathHelper.cos(limbSwing * w1 ) * limbSwingAmount;
		l2.rotateAngleX = A1 * MathHelper.cos(limbSwing * w1 + pi) * limbSwingAmount;
		l3.rotateAngleX = A1 * MathHelper.cos(limbSwing * w1 ) * limbSwingAmount;
		l4.rotateAngleX = A1 * MathHelper.cos(limbSwing * w1 + pi) * limbSwingAmount;

		head.rotateAngleY = A2 * MathHelper.cos(ageInTicks * w2 + pi * 1/5);
		//head.rotateAngleZ=(float)(ageInTicks % (2 * pi));

		b1.rotateAngleY = A2 * MathHelper.cos(ageInTicks * w2 + pi * 2/5);

		b2.rotateAngleY = A2 * MathHelper.cos(ageInTicks * w2 + pi * 3/5);
		r1.rotateAngleY = A2 * MathHelper.cos(ageInTicks * w2 + pi * 3/5);
		r2.rotateAngleY = A2 * MathHelper.cos(ageInTicks * w2 + pi * 3/5);
		l1.rotateAngleY = A2 * MathHelper.cos(ageInTicks * w2 + pi * 3/5);
		l2.rotateAngleY = A2 * MathHelper.cos(ageInTicks * w2 + pi * 3/5);

		b3.rotateAngleY = A2 * MathHelper.cos(ageInTicks * w2 + pi * 4/5);

		b4.rotateAngleY = A2 * MathHelper.cos(ageInTicks * w2 + pi);
		r3.rotateAngleY = A2 * MathHelper.cos(ageInTicks * w2 + pi);
		r4.rotateAngleY = A2 * MathHelper.cos(ageInTicks * w2 + pi);
		l3.rotateAngleY = A2 * MathHelper.cos(ageInTicks * w2 + pi);
		l4.rotateAngleY = A2 * MathHelper.cos(ageInTicks * w2 + pi);

		b5.rotateAngleY = A2 * MathHelper.cos(ageInTicks * w2 + pi * 6/5);

		tail.rotateAngleY =A2 * MathHelper.cos(ageInTicks * w2 + pi * 7/5);
	}
}
