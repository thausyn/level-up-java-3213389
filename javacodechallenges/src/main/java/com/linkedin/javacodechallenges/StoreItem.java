package com.linkedin.javacodechallenges;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;

public class StoreItem {
  String name;
  double retailPrice;
  double discount;

  public static Optional<StoreItem> findLeastExpensive(Collection<StoreItem> items){
    return items.stream()
      .min(Comparator.comparing(StoreItem::calculateCurrentPrice));
  }

  private double calculateCurrentPrice(){
    return retailPrice - (retailPrice * discount);
  }

  publ
}
