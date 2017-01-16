package io.citrine.jcc.search.pif.result;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import io.citrine.jcc.search.core.result.BaseSearchResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Class to store all of the results that were returned from a query. This class implements {@link Iterable} so that
 * users can iterate over results using:
 *
 * <pre>
 * {@code
 * SearchResult searchResult = Query.execute();
 * for (SearchHit i : searchResult) {
 *     // do work on hit
 * }
 * }
 * </pre>
 *
 * @author Kyle Michel
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PifSearchResult extends BaseSearchResult implements Iterable<PifSearchHit> {

    @Override
    @JsonSetter("took")
    public PifSearchResult setTook(final Long took) {
        super.setTook(took);
        return this;
    }

    @Override
    @JsonSetter("totalNumHits")
    public PifSearchResult setTotalNumHits(final Long totalNumHits) {
        super.setTotalNumHits(totalNumHits);
        return this;
    }

    /**
     * Set the list of hits that were matched. This overwrites any hits that are already saved.
     *
     * @param hits List of {@link PifSearchHit} objects.
     * @return This object.
     */
    @JsonSetter("hits")
    protected PifSearchResult setHits(final List<PifSearchHit> hits) {
        this.hits = hits;
        return this;
    }

    /**
     * Add a single hit that was matched.
     *
     * @param hit {@link PifSearchHit} to add to the results set.
     * @return This object.
     */
    @JsonIgnore
    public PifSearchResult addHit(final PifSearchHit hit) {
        if (this.hits == null) {
            this.hits = new ArrayList<>();
        }
        this.hits.add(hit);
        return this;
    }

    /**
     * Get the list of hits that were matched.
     *
     * @return List of {@link PifSearchHit} objects.
     */
    @JsonGetter("hits")
    protected List<PifSearchHit> getHits() {
        return this.hits;
    }

    /**
     * Get the number of hits that were matched.
     *
     * @return Number of hits in the result set.
     */
    @JsonIgnore
    public int getNumHits() {
        return (this.hits == null) ? 0 : this.hits.size();
    }

    /**
     * Get a hit at the set index.
     *
     * @param index Index of the hit to return.
     * @return {@link PifSearchHit} at the input index.
     * @throws IllegalArgumentException if the index is out of bounds.
     */
    @JsonIgnore
    public PifSearchHit getHit(final int index) {
        if (this.hits == null) {
            throw new IndexOutOfBoundsException("Index out of range: " + index + " of 0");
        }
        return this.hits.get(index);
    }

    @Override
    @JsonIgnore
    public Iterator<PifSearchHit> iterator() {
        return (this.hits == null) ? Collections.emptyIterator() : hits.iterator();
    }

    /** List of hits. */
    private List<PifSearchHit> hits;
}