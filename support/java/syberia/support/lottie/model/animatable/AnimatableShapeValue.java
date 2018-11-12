package syberia.support.lottie.model.animatable;

import android.graphics.Path;

import syberia.support.lottie.value.Keyframe;
import syberia.support.lottie.animation.keyframe.BaseKeyframeAnimation;
import syberia.support.lottie.animation.keyframe.ShapeKeyframeAnimation;
import syberia.support.lottie.model.content.ShapeData;

import java.util.List;

public class AnimatableShapeValue extends BaseAnimatableValue<ShapeData, Path> {

  public AnimatableShapeValue(List<Keyframe<ShapeData>> keyframes) {
    super(keyframes);
  }

  @Override public BaseKeyframeAnimation<ShapeData, Path> createAnimation() {
    return new ShapeKeyframeAnimation(keyframes);
  }
}
