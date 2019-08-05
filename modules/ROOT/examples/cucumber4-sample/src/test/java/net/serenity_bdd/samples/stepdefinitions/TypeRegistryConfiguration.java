package net.serenity_bdd.samples.stepdefinitions;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterType;
import io.cucumber.datatable.TableCellByTypeTransformer;
import io.cucumber.datatable.TableEntryByTypeTransformer;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import net.serenity_bdd.samples.domain.AccountType;
import net.serenitybdd.screenplay.Actor;

import java.util.Locale;
import java.util.Map;

import static java.util.Locale.ENGLISH;

//import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;

public class TypeRegistryConfiguration implements TypeRegistryConfigurer {
    @Override
    public Locale locale() {
        return ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineParameterType(ParameterType.fromEnum(AccountType.class));

        Transformer transformer = new Transformer();
        typeRegistry.setDefaultDataTableEntryTransformer(transformer);

        typeRegistry.defineParameterType(new ParameterType<>(
                "actor",
                ".*",
                Actor.class,
                (String actorName) -> Actor.named(actorName))
        );
    }

    private class Transformer implements TableEntryByTypeTransformer { //},ParameterByTypeTransformer, TableCellByTypeTransformer {
        ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public <T> T transform(Map<String, String> map, Class<T> aClass, TableCellByTypeTransformer tableCellByTypeTransformer) {
            return objectMapper.convertValue(map, aClass);
        }
    }
}
