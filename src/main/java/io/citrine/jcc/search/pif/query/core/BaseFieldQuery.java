package io.citrine.jcc.search.pif.query.core;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import io.citrine.jcc.search.core.query.HasLogic;
import io.citrine.jcc.search.core.query.Logic;
import io.citrine.jcc.util.ListUtil;

import java.util.List;


/**
 * Base class for all field queries.
 *
 * @author Kyle Michel
 */
public abstract class BaseFieldQuery implements HasLogic {

    @Override
    @JsonSetter("logic")
    public BaseFieldQuery logic(final Logic logic) {
        this.logic = logic;
        return this;
    }

    @Override
    @JsonGetter("logic")
    public Logic logic() {
        return this.logic;
    }

    /**
     * Set the alias to save this field under.
     *
     * @param extractAs String with the alias to save this field under.
     * @return This object.
     */
    @JsonSetter("extractAs")
    public BaseFieldQuery extractAs(final String extractAs) {
        this.extractAs = extractAs;
        return this;
    }

    /**
     * Get the alias to save this field under.
     *
     * @return String with the alias to save this field under or a null pointer if not set.
     */
    @JsonGetter("extractAs")
    public String extractAs() {
        return this.extractAs;
    }

    /**
     * Set whether to extract all values in an array.
     *
     * @param extractAll True to extract all values from an array.
     * @return This object.
     */
    @JsonSetter("extractAll")
    public BaseFieldQuery extractAll(final Boolean extractAll) {
        this.extractAll = extractAll;
        return this;
    }

    /**
     * Get whether to extract all values in an array.
     *
     * @return True if all values should be extracted from an array.
     */
    @JsonGetter("extractAll")
    public Boolean extractAll() {
        return this.extractAll;
    }

    /**
     * Set the value to return when an extract value is not found. This value is only returned when an optional query
     * misses or when a SHOULD query misses but another query in that SHOULD block does hit.
     *
     * @param extractWhenMissing Object to return when the overall query is satisfied but the extract value is missing.
     * @return This object.
     */
    @JsonSetter("extractWhenMissing")
    public BaseFieldQuery extractWhenMissing(final Object extractWhenMissing) {
        this.extractWhenMissing = extractWhenMissing;
        return this;
    }

    /**
     * Get the value to return whether an extracted value is missing.
     *
     * @return Object with the value to return when an extracted value is missing.
     */
    @JsonGetter
    public Object extractWhenMissing() {
        return this.extractWhenMissing;
    }

    /**
     * Set whether top level filters should be floated. This is intended to be a private method since it should only
     * be used by templates.
     *
     * @param floatTopFilters True to float top level filters.
     */
    @JsonSetter("floatTopFilters")
    private void floatTopFilters(final Boolean floatTopFilters) {  // Private since only Jackson should use it
        this.floatTopFilters = floatTopFilters;
    }

    /**
     * Get whether top level filters should be floated.
     *
     * @return True if top level filters should be floated or a null pointer if it has not been set.
     */
    @JsonGetter("floatTopFilters")
    public Boolean floatTopFilters() {
        return this.floatTopFilters;
    }

    /**
     * Set the length operations. This adds to any operations that are already saved.
     *
     * @param length List of {@link FieldQuery} objects.
     */
    @JsonSetter("length")
    private void length(final List<FieldQuery> length) {  // Private since only Jackson should use it
        this.length = ListUtil.add(length, this.length);
    }

    /**
     * Add to the list of length operations.
     *
     * @param fieldQuery {@link FieldQuery} to add.
     * @return This object.
     */
    @JsonIgnore
    public BaseFieldQuery length(final FieldQuery fieldQuery) {
        this.length = ListUtil.add(fieldQuery, this.length);
        return this;
    }

    /**
     * Add to the list of length operations.
     *
     * @param extractAs Alias to extract as.
     * @return This object.
     */
    @JsonIgnore
    public BaseFieldQuery length(final String extractAs) {
        this.length = ListUtil.add(new FieldQuery().extractAs(extractAs), this.length);
        return this;
    }

    /**
     * Add to the list of length operations.
     *
     * @param filter {@link Filter} object to apply.
     * @return This object.
     */
    @JsonIgnore
    public BaseFieldQuery length(final Filter filter) {
        this.length = ListUtil.add(new FieldQuery().filter(filter), this.length);
        return this;
    }

    /**
     * Get an iterable over length operations.
     *
     * @return Iterable of {@link FieldQuery} objects.
     */
    @JsonGetter("length")
    public Iterable<FieldQuery> length() {
        return ListUtil.iterable(this.length);
    }

    /**
     * Return whether any length operations exist.
     *
     * @return True if any length operations exist.
     */
    @JsonIgnore
    public boolean hasLength() {
        return ListUtil.hasContent(this.length);
    }

    /**
     * Set the offset operations. This adds to any operations that are already saved.
     *
     * @param offset List of {@link FieldQuery} objects.
     */
    @JsonSetter("offset")
    private void offset(final List<FieldQuery> offset) {  // Private since only Jackson should use it
        this.offset = ListUtil.add(offset, this.offset);
    }

    /**
     * Add to the list of offset operations.
     *
     * @param fieldQuery {@link FieldQuery} to add.
     * @return This object.
     */
    @JsonIgnore
    public BaseFieldQuery offset(final FieldQuery fieldQuery) {
        this.offset = ListUtil.add(fieldQuery, this.offset);
        return this;
    }

    /**
     * Add to the list of offset operations.
     *
     * @param extractAs Alias to extract as.
     * @return This object.
     */
    @JsonIgnore
    public BaseFieldQuery offset(final String extractAs) {
        this.offset = ListUtil.add(new FieldQuery().extractAs(extractAs), this.offset);
        return this;
    }

    /**
     * Add to the list of offset operations.
     *
     * @param filter {@link Filter} to apply.
     * @return This object.
     */
    @JsonIgnore
    public BaseFieldQuery offset(final Filter filter) {
        this.offset = ListUtil.add(new FieldQuery().filter(filter), this.offset);
        return this;
    }

    /**
     * Get an iterable over offset operations.
     *
     * @return Iterable of {@link FieldQuery} objects.
     */
    @JsonGetter("offset")
    public Iterable<FieldQuery> offset() {
        return ListUtil.iterable(this.offset);
    }

    /**
     * Return whether any offset operations exist.
     *
     * @return True if any offset operations exist.
     */
    @JsonIgnore
    public boolean hasOffset() {
        return ListUtil.hasContent(this.offset);
    }

    /** Logic that applies to the entire query. */
    private Logic logic;

    /** Alias to save this field under. */
    private String extractAs;

    /** Whether to extract all values in an array. */
    private Boolean extractAll;

    /** Default value to return if a field is missing and the query part is optional. */
    private Object extractWhenMissing;

    /** Set whether top level filters should be floated out into their own objects. */
    private Boolean floatTopFilters;

    /** Length of that array that this object appears in. */
    private List<FieldQuery> length;

    /** Offset of this object in the array that it appears in. */
    private List<FieldQuery> offset;
}