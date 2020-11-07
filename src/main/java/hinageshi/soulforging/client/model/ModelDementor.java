package hinageshi.soulforging.client.model;

// Made with Blockbench 3.7.2
// Exported for Minecraft version 1.12
// Paste this class into your mod and generate all required imports

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDementor extends ModelBase {
	private final ModelRenderer body;
	private final ModelRenderer tail_r1;
	private final ModelRenderer B;
	private final ModelRenderer S;
	private final ModelRenderer feet;
	private final ModelRenderer R;
	private final ModelRenderer L;

	public ModelDementor() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 22.0F, 0.0F);
		

		tail_r1 = new ModelRenderer(this);
		tail_r1.setRotationPoint(0.0F, -6.0F, 8.0F);
		body.addChild(tail_r1);
		setRotationAngle(tail_r1, -1.0472F, 0.0F, 0.0F);
		tail_r1.cubeList.add(new ModelBox(tail_r1, 15, 39, -1.0F, -1.0F, 0.0F, 2, 2, 7, 0.0F, false));

		B = new ModelRenderer(this);
		B.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(B);
		B.cubeList.add(new ModelBox(B, 29, 29, -6.0F, -12.0F, -9.0F, 12, 12, 5, 0.0F, false));
		B.cubeList.add(new ModelBox(B, 0, 17, -6.0F, -12.0F, -3.0F, 12, 12, 5, 0.0F, false));
		B.cubeList.add(new ModelBox(B, 0, 0, -6.0F, -12.0F, 3.0F, 12, 12, 5, 0.0F, false));

		S = new ModelRenderer(this);
		S.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(S);
		S.cubeList.add(new ModelBox(S, 34, 11, -5.0F, -11.0F, -4.0F, 10, 10, 1, 0.0F, false));
		S.cubeList.add(new ModelBox(S, 34, 0, -5.0F, -11.0F, 2.0F, 10, 10, 1, 0.0F, false));
		S.cubeList.add(new ModelBox(S, 0, 34, -5.0F, -11.0F, 8.0F, 10, 10, 1, 0.0F, false));

		feet = new ModelRenderer(this);
		feet.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		R = new ModelRenderer(this);
		R.setRotationPoint(1.0F, 0.0F, 0.0F);
		feet.addChild(R);
		R.cubeList.add(new ModelBox(R, 47, 47, -6.0F, -2.0F, -3.0F, 2, 2, 2, 0.0F, false));
		R.cubeList.add(new ModelBox(R, 46, 22, -6.0F, -2.0F, 0.0F, 2, 2, 2, 0.0F, false));
		R.cubeList.add(new ModelBox(R, 39, 46, -6.0F, -2.0F, 3.0F, 2, 2, 2, 0.0F, false));
		R.cubeList.add(new ModelBox(R, 31, 46, -6.0F, -2.0F, 6.0F, 2, 2, 2, 0.0F, false));

		L = new ModelRenderer(this);
		L.setRotationPoint(9.0F, 0.0F, 0.0F);
		feet.addChild(L);
		L.cubeList.add(new ModelBox(L, 8, 46, -6.0F, -2.0F, -3.0F, 2, 2, 2, 0.0F, false));
		L.cubeList.add(new ModelBox(L, 0, 45, -6.0F, -2.0F, 0.0F, 2, 2, 2, 0.0F, false));
		L.cubeList.add(new ModelBox(L, 40, 24, -6.0F, -2.0F, 3.0F, 2, 2, 2, 0.0F, false));
		L.cubeList.add(new ModelBox(L, 34, 22, -6.0F, -2.0F, 6.0F, 2, 2, 2, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float scale) {
		body.render(scale);
		feet.render(scale);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}