package syberia.support.lottie.model.animatable;

import syberia.support.lottie.value.Keyframe;
import syberia.support.lottie.animation.keyframe.TextKeyframeAnimation;
import syberia.support.lottie.model.DocumentData;

import java.util.List;

public class AnimatableTextFrame extends BaseAnimatableValue<DocumentData, DocumentData> {

  public AnimatableTextFrame(List<Keyframe<DocumentData>> keyframes) {
    super(keyframes);
  }

  @Override public TextKeyframeAnimation createAnimation() {
    return new TextKeyframeAnimation(keyframes);
  }
}
