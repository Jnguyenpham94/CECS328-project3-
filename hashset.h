#pragma once

#include <functional>
#include <vector>

template <typename TValue, typename TFunc>
class HashSet
{
private:
	// Unlike Java, the C++ hashtable array won't be full of null references.
	// It will be full of "Entry" objects, each of which tracks its current state
	// as EMPTY, FULL (with a value), or NIL (value was once here, but was removed).
	class Entry
	{
	public:
		enum EntryState {EMPTY, FULL, NIL};

		TValue value;
		EntryState state;

		Entry() : value(), state(EMPTY) {}
		Entry(const TValue& v) : value(v), state(EMPTY) {}
	};
	
	TFunc mHash;
	std::vector<Entry> mTable;
	std::size_t mCount;

public:
	// Constructs a hashtable with the given size, using the given function for
	// computing h(k).
	// hash must be a callable object (function, functor, etc.) that takes a parameter
	//    of type TValue and returns std::size_t (an integer).
	HashSet(int size, TFunc hash) : mHash(hash)
	{
		// TODO: see requirement #4.
		mTable.resize(size); // resizes the vector to have given size.
							 // Each element will be default-constructed to have state EMPTY.
	}

	// Inserts the given value into the set.
	void add(const TValue& value)
	{
		// Use the type std::size_t for working with hash table indices.
		// Invoke the mHash function, passing the key to calculate h(k), as in

		// size_t hashCode = mHash(value);

		// Mod down to size.
		// Go to the table at that index and do the insertion routine.
	}

    // Returns true if the given value is present in the set.
	bool find(const TValue& key)
	{
	}

	// Removes the given value from the set.
	void remove(const TValue& key)
	{
	}
};