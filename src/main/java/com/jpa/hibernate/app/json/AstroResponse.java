package com.jpa.hibernate.app.json;
import java.util.List;
public record AstroResponse(String message,
                            int number,
                            List<Assigment> people) {
  record Assigment(String craft, String name) {
  }
}
