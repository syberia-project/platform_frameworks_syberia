package syberia.support.lottie.model.animatable;

import android.graphics.PointF;
import android.support.annotation.Nullable;

import syberia.support.lottie.LottieDrawable;
import syberia.support.lottie.animation.content.Content;
import syberia.support.lottie.animation.content.ModifierContent;
import syberia.support.lottie.animation.keyframe.TransformKeyframeAnimation;
import syberia.support.lottie.model.content.ContentModel;
import syberia.support.lottie.model.layer.BaseLayer;

public class AnimatableTransform implements ModifierContent, ContentModel {
  private final AnimatablePathValue anchorPoint;
  private final AnimatableValue<PointF, PointF> position;
  private final AnimatableScaleValue scale;
  private final AnimatableFloatValue rotation;
  private final AnimatableIntegerValue opacity;

  // Used for repeaters
  @Nullable private final AnimatableFloatValue startOpacity;
  @Nullable private final AnimatableFloatValue endOpacity;

  public AnimatableTransform() {
    this(
        new AnimatablePathValue(),
        new AnimatablePathValue(),
        new AnimatableScaleValue(),
        new AnimatableFloatValue(),
        new AnimatableIntegerValue(),
        new AnimatableFloatValue(),
        new AnimatableFloatValue()
    );
  }

  public AnimatableTransform(AnimatablePathValue anchorPoint,
      AnimatableValue<PointF, PointF> position, AnimatableScaleValue scale,
      AnimatableFloatValue rotation, AnimatableIntegerValue opacity,
      @Nullable AnimatableFloatValue startOpacity, @Nullable AnimatableFloatValue endOpacity) {
    this.anchorPoint = anchorPoint;
    this.position = position;
    this.scale = scale;
    this.rotation = rotation;
    this.opacity = opacity;
    this.startOpacity = startOpacity;
    this.endOpacity = endOpacity;
  }

  public AnimatablePathValue getAnchorPoint() {
    return anchorPoint;
  }

  public AnimatableValue<PointF, PointF> getPosition() {
    return position;
  }

  public AnimatableScaleValue getScale() {
    return scale;
  }

  public AnimatableFloatValue getRotation() {
    return rotation;
  }

  public AnimatableIntegerValue getOpacity() {
    return opacity;
  }

  @Nullable public AnimatableFloatValue getStartOpacity() {
    return startOpacity;
  }

  @Nullable public AnimatableFloatValue getEndOpacity() {
    return endOpacity;
  }

  public TransformKeyframeAnimation createAnimation() {
    return new TransformKeyframeAnimation(this);
  }

  @Nullable @Override public Content toContent(LottieDrawable drawable, BaseLayer layer) {
    return null;
  }
}
