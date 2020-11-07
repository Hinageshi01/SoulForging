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
		head.cubeList.add(new ModelBox(head, 29, 29, -6.0F, -14.0F, -9.0F, 12, 12, 5, 0.0F, false));

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 24.0F, 0.0F);


		tail_r1 = new ModelRenderer(this);
		tail_r1.setRotationPoint(0.0F, -8.0F, 8.0F);
		tail.addChild(tail_r1);
		setRotationAngle(tail_r1, -1.0472F, 0.0F, 0.0F);
		tail_r1.cubeList.add(new ModelBox(tail_r1, 19, 46, -1.0F, -1.0F, 0.0F, 2, 2, 7, 0.0F, false));

		l4 = new ModelRenderer(this);
		l4.setRotationPoint(0.0F, 24.0F, 0.0F);
		l4.cubeList.add(new ModelBox(l4, 34, 22, 3.0F, -2.0F, 6.0F, 2, 2, 2, 0.0F, false));

		l3 = new ModelRenderer(this);
		l3.setRotationPoint(0.0F, 24.0F, 0.0F);
		l3.cubeList.add(new ModelBox(l3, 40, 24, 3.0F, -2.0F, 3.0F, 2, 2, 2, 0.0F, false));

		l2 = new ModelRenderer(this);
		l2.setRotationPoint(0.0F, 24.0F, 0.0F);
		l2.cubeList.add(new ModelBox(l2, 30, 46, 3.0F, -2.0F, 0.0F, 2, 2, 2, 0.0F, false));

		l1 = new ModelRenderer(this);
		l1.setRotationPoint(5.0F, 24.0F, -2.0F);
		l1.cubeList.add(new ModelBox(l1, 38, 46, -2.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F, false));

		r4 = new ModelRenderer(this);
		r4.setRotationPoint(0.0F, 24.0F, 0.0F);
		r4.cubeList.add(new ModelBox(r4, 46, 46, -5.0F, -2.0F, 6.0F, 2, 2, 2, 0.0F, false));

		r3 = new ModelRenderer(this);
		r3.setRotationPoint(0.0F, 24.0F, 0.0F);
		r3.cubeList.add(new ModelBox(r3, 46, 22, -5.0F, -2.0F, 3.0F, 2, 2, 2, 0.0F, false));

		r2 = new ModelRenderer(this);
		r2.setRotationPoint(0.0F, 24.0F, 0.0F);
		r2.cubeList.add(new ModelBox(r2, 0, 47, -5.0F, -2.0F, 0.0F, 2, 2, 2, 0.0F, false));

		r1 = new ModelRenderer(this);
		r1.setRotationPoint(0.0F, 24.0F, 0.0F);
		r1.cubeList.add(new ModelBox(r1, 8, 47, -5.0F, -2.0F, -3.0F, 2, 2, 2, 0.0F, false));

		b5 = new ModelRenderer(this);
		b5.setRotationPoint(0.0F, 24.0F, 0.0F);
		b5.cubeList.add(new ModelBox(b5, 34, 0, -5.0F, -13.0F, 8.0F, 10, 10, 1, 0.0F, false));

		b4 = new ModelRenderer(this);
		b4.setRotationPoint(0.0F, 24.0F, 0.0F);
		b4.cubeList.add(new ModelBox(b4, 0, 0, -6.0F, -14.0F, 3.0F, 12, 12, 5, 0.0F, false));

		b3 = new ModelRenderer(this);
		b3.setRotationPoint(0.0F, 24.0F, 0.0F);
		b3.cubeList.add(new ModelBox(b3, 34, 11, -5.0F, -13.0F, 2.0F, 10, 10, 1, 0.0F, false));

		b2 = new ModelRenderer(this);
		b2.setRotationPoint(0.0F, 24.0F, 0.0F);
		b2.cubeList.add(new ModelBox(b2, 0, 17, -6.0F, -14.0F, -3.0F, 12, 12, 5, 0.0F, false));

		b1 = new ModelRenderer(this);
		b1.setRotationPoint(0.0F, 24.0F, 0.0F);
		b1.cubeList.add(new ModelBox(b1, 0, 34, -5.0F, -13.0F, -6.0F, 10, 10, 3, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		head.render(f5);
		tail.render(f5);
		l4.render(f5);
		l3.render(f5);
		l2.render(f5);
		l1.render(f5);
		r4.render(f5);
		r3.render(f5);
		r2.render(f5);
		r1.render(f5);
		b5.render(f5);
		b4.render(f5);
		b3.render(f5);
		b2.render(f5);
		b1.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		final float A=0.45F,w=2.0F,pi=(float)Math.PI;
		head.rotateAngleX = pi / 180 * headPitch;
		head.rotateAngleY = pi / 180 * netHeadYaw;

		r1.rotateAngleX = A * MathHelper.cos(limbSwing * w + pi) * limbSwingAmount;
		r2.rotateAngleX = A * MathHelper.cos(limbSwing * w ) * limbSwingAmount;
		r3.rotateAngleX = A * MathHelper.cos(limbSwing * w + pi) * limbSwingAmount;
		r4.rotateAngleX = A * MathHelper.cos(limbSwing * w ) * limbSwingAmount;

		l1.rotateAngleX = A * MathHelper.cos(limbSwing * w ) * limbSwingAmount;
		l2.rotateAngleX = A * MathHelper.cos(limbSwing * w + pi) * limbSwingAmount;
		l3.rotateAngleX = A * MathHelper.cos(limbSwing * w ) * limbSwingAmount;
		l4.rotateAngleX = A * MathHelper.cos(limbSwing * w + pi) * limbSwingAmount;
	}
}
