package syberia.support.lottie.model.animatable;

import syberia.support.lottie.value.Keyframe;
import syberia.support.lottie.animation.keyframe.BaseKeyframeAnimation;
import syberia.support.lottie.animation.keyframe.FloatKeyframeAnimation;

import java.util.List;

public class AnimatableFloatValue extends BaseAnimatableValue<Float, Float> {

  AnimatableFloatValue() {
    super(0f);
  }

  public AnimatableFloatValue(List<Keyframe<Float>> keyframes) {
    super(keyframes);
  }

  @Override public BaseKeyframeAnimation<Float, Float> createAnimation() {
    return new FloatKeyframeAnimation(keyframes);
  }
}
