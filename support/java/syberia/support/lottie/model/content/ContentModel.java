package syberia.support.lottie.model.content;


import android.support.annotation.Nullable;

import syberia.support.lottie.LottieDrawable;
import syberia.support.lottie.animation.content.Content;
import syberia.support.lottie.model.layer.BaseLayer;

public interface ContentModel {
  @Nullable Content toContent(LottieDrawable drawable, BaseLayer layer);
}
