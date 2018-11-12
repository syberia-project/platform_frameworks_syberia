package syberia.support.lottie.parser;

import android.support.annotation.Nullable;
import android.util.JsonReader;

import syberia.support.lottie.LottieComposition;
import syberia.support.lottie.value.Keyframe;
import syberia.support.lottie.model.animatable.AnimatableColorValue;
import syberia.support.lottie.model.animatable.AnimatableFloatValue;
import syberia.support.lottie.model.animatable.AnimatableGradientColorValue;
import syberia.support.lottie.model.animatable.AnimatableIntegerValue;
import syberia.support.lottie.model.animatable.AnimatablePointValue;
import syberia.support.lottie.model.animatable.AnimatableScaleValue;
import syberia.support.lottie.model.animatable.AnimatableShapeValue;
import syberia.support.lottie.model.animatable.AnimatableTextFrame;
import syberia.support.lottie.utils.Utils;

import java.io.IOException;
import java.util.List;

public class AnimatableValueParser {
  private AnimatableValueParser() {
  }

  public static AnimatableFloatValue parseFloat(
      JsonReader reader, LottieComposition composition) throws IOException {
    return parseFloat(reader, composition, true);
  }

  public static AnimatableFloatValue parseFloat(
      JsonReader reader, LottieComposition composition, boolean isDp) throws IOException {
    return new AnimatableFloatValue(
        parse(reader, isDp ? Utils.dpScale() : 1f, composition, FloatParser.INSTANCE));
  }

  static AnimatableIntegerValue parseInteger(
      JsonReader reader, LottieComposition composition) throws IOException {
    return new AnimatableIntegerValue(parse(reader, composition, IntegerParser.INSTANCE));
  }

  static AnimatablePointValue parsePoint(
      JsonReader reader, LottieComposition composition) throws IOException {
    return new AnimatablePointValue(
        parse(reader, Utils.dpScale(), composition, PointFParser.INSTANCE));
  }

  static AnimatableScaleValue parseScale(
      JsonReader reader, LottieComposition composition) throws IOException {
    return new AnimatableScaleValue(parse(reader, composition, ScaleXYParser.INSTANCE));
  }

  static AnimatableShapeValue parseShapeData(
      JsonReader reader, LottieComposition composition) throws IOException {
    return new AnimatableShapeValue(
        parse(reader, Utils.dpScale(), composition, ShapeDataParser.INSTANCE));
  }

  static AnimatableTextFrame parseDocumentData(
      JsonReader reader, LottieComposition composition) throws IOException {
    return new AnimatableTextFrame(parse(reader, composition, DocumentDataParser.INSTANCE));
  }

  static AnimatableColorValue parseColor(
      JsonReader reader, LottieComposition composition) throws IOException {
    return new AnimatableColorValue(parse(reader, composition, ColorParser.INSTANCE));
  }

  static AnimatableGradientColorValue parseGradientColor(
      JsonReader reader, LottieComposition composition, int points) throws IOException {
    return new AnimatableGradientColorValue(
        parse(reader, composition, new GradientColorParser(points)));
  }

  /**
   * Will return null if the animation can't be played such as if it has expressions.
   */
  @Nullable private static <T> List<Keyframe<T>> parse(JsonReader reader,
      LottieComposition composition, ValueParser<T> valueParser) throws IOException {
    return KeyframesParser.parse(reader, composition, 1, valueParser);
  }

  /**
   * Will return null if the animation can't be played such as if it has expressions.
   */
  @Nullable private static <T> List<Keyframe<T>> parse(JsonReader reader, float scale,
      LottieComposition composition, ValueParser<T> valueParser) throws IOException {
    return KeyframesParser.parse(reader, composition, scale, valueParser);
  }
}
