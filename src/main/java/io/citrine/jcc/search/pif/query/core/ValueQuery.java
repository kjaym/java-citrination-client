package io.citrine.jcc.search.pif.query.core;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import io.citrine.jcc.search.core.query.Logic;
import io.citrine.jcc.util.ListUtil;

import java.util.List;

/**
 * Class for querying against a single value.
 * 
 * @author Kyle Michel
 */
public class ValueQuery extends BaseObjectQuery {

    /**
     * Set the list of name operations. This adds to any operations that already exist.
     *
     * @param name List of {@link FieldQuery} objects.
     */
    @JsonSetter("name")
    private void name(final List<FieldQuery> name) {
        this.name = ListUtil.add(name, this.name);
    }

    /**
     * Add a single name operation.
     *
     * @param fieldQuery {@link FieldQuery} to add.
     * @return This object.
     */
    @JsonIgnore
    public ValueQuery name(final FieldQuery fieldQuery) {
        this.name = ListUtil.add(fieldQuery, this.name);
        return this;
    }

    /**
     * Add a single name operation.
     *
     * @param extractAs Alias to extract as.
     * @return This object.
     */
    @JsonIgnore
    public ValueQuery name(final String extractAs) {
        this.name = ListUtil.add(new FieldQuery().extractAs(extractAs), this.name);
        return this;
    }

    /**
     * Add a single name operation.
     *
     * @param filter {@link Filter} to apply.
     * @return This object.
     */
    @JsonIgnore
    public ValueQuery name(final Filter filter) {
        this.name = ListUtil.add(new FieldQuery().filter(filter), this.name);
        return this;
    }

    /**
     * Get an iterable object over the names fields.
     *
     * @return Iterable of {@link FieldQuery} objects.
     */
    @JsonGetter("name")
    public Iterable<FieldQuery> name() {
        return ListUtil.iterable(this.name);
    }

    /**
     * Return whether any name operations exist.
     *
     * @return True if any name operations exist.
     */
    @JsonIgnore
    public boolean hasName() {
        return ListUtil.hasContent(this.name);
    }

    /**
     * Set the list of value operations. This adds to any operations that already exist.
     *
     * @param value List of {@link FieldQuery} objects.
     */
    @JsonSetter("value")
    private void value(final List<FieldQuery> value) {
        this.value = ListUtil.add(value, this.value);
    }

    /**
     * Add a single value operation.
     *
     * @param fieldQuery {@link FieldQuery} to add.
     * @return This object.
     */
    @JsonIgnore
    public ValueQuery value(final FieldQuery fieldQuery) {
        this.value = ListUtil.add(fieldQuery, this.value);
        return this;
    }

    /**
     * Add a single value operation.
     *
     * @param extractAs Alias to extract as.
     * @return This object.
     */
    @JsonIgnore
    public ValueQuery value(final String extractAs) {
        this.value = ListUtil.add(new FieldQuery().extractAs(extractAs), this.value);
        return this;
    }

    /**
     * Add a single value operation.
     *
     * @param filter {@link Filter} to apply.
     * @return This object.
     */
    @JsonIgnore
    public ValueQuery value(final Filter filter) {
        this.value = ListUtil.add(new FieldQuery().filter(filter), this.value);
        return this;
    }

    /**
     * Get an iterable over the list of name operations.
     *
     * @return Iterable of {@link FieldQuery} objects.
     */
    @JsonGetter("value")
    public Iterable<FieldQuery> value() {
        return ListUtil.iterable(this.value);
    }

    /**
     * Return whether any value operations exist.
     *
     * @return True if any value operations exist.
     */
    @JsonIgnore
    public boolean hasValue() {
        return ListUtil.hasContent(this.value);
    }

    /**
     * Set the list of file reference operations. This adds to any operations that are already saved.
     *
     * @param file List of {@link FileReferenceQuery} objects.
     */
    @JsonSetter("file")
    private void file(final List<FileReferenceQuery> file) {
        this.file = ListUtil.add(file, this.file);
    }

    /**
     * Add to the list of file reference operations.
     *
     * @param file {@link FileReferenceQuery} object to add.
     * @return This object.
     */
    @JsonIgnore
    public ValueQuery file(final FileReferenceQuery file) {
        this.file = ListUtil.add(file, this.file);
        return this;
    }

    /**
     * Get an iterable of file reference operations.
     *
     * @return Iterable of {@link FileReferenceQuery} objects.
     */
    @JsonGetter("file")
    public Iterable<FileReferenceQuery> file() {
        return ListUtil.iterable(this.file);
    }

    /**
     * Get whether an file reference queries exist.
     *
     * @return True if any file reference queries exist.
     */
    @JsonIgnore
    public boolean hasFile() {
        return ListUtil.hasContent(this.file);
    }

    /**
     * Set the list of units operations. This adds to any operations that already exist.
     *
     * @param units List of {@link FieldQuery} objects.
     */
    @JsonSetter("units")
    private void units(final List<FieldQuery> units) {
        this.units = ListUtil.add(units, this.units);
    }

    /**
     * Add a single units operation.
     *
     * @param fieldQuery {@link FieldQuery} to add.
     * @return This object.
     */
    @JsonIgnore
    public ValueQuery units(final FieldQuery fieldQuery) {
        this.units = ListUtil.add(fieldQuery, this.units);
        return this;
    }

    /**
     * Add a single units operation.
     *
     * @param extractAs Alias to extract as.
     * @return This object.
     */
    @JsonIgnore
    public ValueQuery units(final String extractAs) {
        this.units = ListUtil.add(new FieldQuery().extractAs(extractAs), this.units);
        return this;
    }

    /**
     * Add a single units operation.
     *
     * @param filter {@link Filter} to apply.
     * @return This object.
     */
    @JsonIgnore
    public ValueQuery units(final Filter filter) {
        this.units = ListUtil.add(new FieldQuery().filter(filter), this.units);
        return this;
    }

    /**
     * Get the list of units operations.
     *
     * @return Iterator over {@link FieldQuery} objects.
     */
    @JsonGetter("units")
    public Iterable<FieldQuery> units() {
        return ListUtil.iterable(this.units);
    }

    /**
     * Return whether any units operations exists.
     *
     * @return True if any units operations exist.
     */
    @JsonIgnore
    public boolean hasUnits() {
        return ListUtil.hasContent(this.units);
    }

    /**
     * Set the normalization for units.
     *
     * @param unitsNormalization {@link UnitsNormalization} to use.
     * @return This object.
     */
    @JsonSetter("unitsNormalization")
    public ValueQuery unitsNormalization(final UnitsNormalization unitsNormalization) {
        this.unitsNormalization = unitsNormalization;
        return this;
    }

    /**
     * Get the units normalizations.
     *
     * @return {@link UnitsNormalization} object or a null pointer if it has not been set.
     */
    @JsonGetter("unitsNormalization")
    public UnitsNormalization unitsNormalization() {
        return this.unitsNormalization;
    }

    /**
     * Whether unit normalizations are set.
     *
     * @return True if unit normalization has been set.
     */
    @JsonIgnore
    public boolean hasUnitsNormalization() {
        return this.unitsNormalization != null;
    }

    @Override
    @JsonSetter("logic")
    public ValueQuery logic(final Logic logic) {
        super.logic(logic);
        return this;
    }

    @Override
    @JsonSetter("extractAs")
    public ValueQuery extractAs(final String extractAs) {
        super.extractAs(extractAs);
        return this;
    }

    @Override
    @JsonSetter("extractAll")
    public ValueQuery extractAll(final Boolean extractAll) {
        super.extractAll(extractAll);
        return this;
    }

    @Override
    @JsonSetter("extractWhenMissing")
    public ValueQuery extractWhenMissing(final Object extractWhenMissing) {
        super.extractWhenMissing(extractWhenMissing);
        return this;
    }

    @Override
    @JsonIgnore
    public ValueQuery tags(final FieldQuery fieldQuery) {
        super.tags(fieldQuery);
        return this;
    }

    @Override
    @JsonIgnore
    public ValueQuery tags(final String extractAs) {
        super.tags(extractAs);
        return this;
    }

    @Override
    @JsonIgnore
    public ValueQuery tags(final Filter filter) {
        super.tags(filter);
        return this;
    }

    @Override
    @JsonIgnore
    public ValueQuery length(final FieldQuery fieldQuery) {
        super.length(fieldQuery);
        return this;
    }

    @Override
    @JsonIgnore
    public ValueQuery length(final String extractAs) {
        super.length(extractAs);
        return this;
    }

    @Override
    @JsonIgnore
    public ValueQuery length(final Filter filter) {
        super.length(filter);
        return this;
    }

    @Override
    @JsonIgnore
    public ValueQuery offset(final FieldQuery fieldQuery) {
        super.offset(fieldQuery);
        return this;
    }

    @Override
    @JsonIgnore
    public ValueQuery offset(final String extractAs) {
        super.offset(extractAs);
        return this;
    }

    @Override
    @JsonIgnore
    public ValueQuery offset(final Filter filter) {
        super.offset(filter);
        return this;
    }

    /** List of name operations. */
    private List<FieldQuery> name;

    /** List of value operations. */
    private List<FieldQuery> value;

    /** List of file reference queries. */
    private List<FileReferenceQuery> file;

    /** List of units operations. */
    private List<FieldQuery> units;

    /** Unit normalization. */
    private UnitsNormalization unitsNormalization;
}