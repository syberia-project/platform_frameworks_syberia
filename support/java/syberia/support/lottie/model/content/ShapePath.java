package syberia.support.lottie.model.content;

import syberia.support.lottie.LottieDrawable;
import syberia.support.lottie.animation.content.Content;
import syberia.support.lottie.animation.content.ShapeContent;
import syberia.support.lottie.model.animatable.AnimatableShapeValue;
import syberia.support.lottie.model.layer.BaseLayer;

public class ShapePath implements ContentModel {
  private final String name;
  private final int index;
  private final AnimatableShapeValue shapePath;

  public ShapePath(String name, int index, AnimatableShapeValue shapePath) {
    this.name = name;
    this.index = index;
    this.shapePath = shapePath;
  }

  public String getName() {
    return name;
  }

  public AnimatableShapeValue getShapePath() {
    return shapePath;
  }

  @Override public Content toContent(LottieDrawable drawable, BaseLayer layer) {
    return new ShapeContent(drawable, layer, this);
  }

  @Override public String toString() {
    return "ShapePath{" + "name=" + name +
        ", index=" + index +
        '}';
  }
}
