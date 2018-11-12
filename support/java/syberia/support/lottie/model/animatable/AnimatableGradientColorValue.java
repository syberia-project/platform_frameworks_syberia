package syberia.support.lottie.model.animatable;

import syberia.support.lottie.value.Keyframe;
import syberia.support.lottie.animation.keyframe.BaseKeyframeAnimation;
import syberia.support.lottie.animation.keyframe.GradientColorKeyframeAnimation;
import syberia.support.lottie.model.content.GradientColor;

import java.util.List;

public class AnimatableGradientColorValue extends BaseAnimatableValue<GradientColor,
    GradientColor> {
  public AnimatableGradientColorValue(
      List<Keyframe<GradientColor>> keyframes) {
    super(keyframes);
  }

  @Override public BaseKeyframeAnimation<GradientColor, GradientColor> createAnimation() {
    return new GradientColorKeyframeAnimation(keyframes);
  }
}
