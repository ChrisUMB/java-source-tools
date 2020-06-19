package blue.sparse.jst.specification.models.mdl;

import blue.sparse.binary.annotation.LengthStatic;

public final class MDLFlexControllerUI {

	public int szindex0;

	// These are used like a union to save space
	// Here are the possible configurations for a UI controller
	//
	// SIMPLE NON-STEREO:	0: control	1: unused	2: unused
	// STEREO:				0: left		1: right	2: unused
	// NWAY NON-STEREO:		0: control	1: unused	2: value
	// NWAY STEREO:			0: left		1: right	2: value
	public int szindex1;
	public int szindex2;
	public byte remaptype;    // See the FlexControllerRemapType_t enum
	public boolean stereo;        // Is this a stereo control?

	@LengthStatic(2)
	public byte[] unused;
	int sznameindex;

	/*
	inline char * const pszName( void ) const { return ((char *)this) + sznameindex; }
	inline const mstudioflexcontroller_t *pController( void ) const
	{
		return !stereo ? (mstudioflexcontroller_t *)( (char *)this + szindex0 ) : NULL;
	}
	inline char * const	pszControllerName( void ) const { return !stereo ? pController()->pszName() : NULL; }
	inline int			controllerIndex( const CStudioHdr &cStudioHdr ) const;

	inline const mstudioflexcontroller_t *pLeftController( void ) const
	{
		return stereo ? (mstudioflexcontroller_t *)( (char *)this + szindex0 ) : NULL;
	}
	inline char * const	pszLeftName( void ) const { return stereo ? pLeftController()->pszName() : NULL; }
	inline int			leftIndex( const CStudioHdr &cStudioHdr ) const;

	inline const mstudioflexcontroller_t *pRightController( void ) const
	{
		return stereo ? (mstudioflexcontroller_t *)( (char *)this + szindex1 ): NULL;
	}
	inline char * const	pszRightName( void ) const { return stereo ? pRightController()->pszName() : NULL; }
	inline int			rightIndex( const CStudioHdr &cStudioHdr ) const;

	inline const mstudioflexcontroller_t *pNWayValueController( void ) const
	{
		return remaptype == FLEXCONTROLLER_REMAP_NWAY ? (mstudioflexcontroller_t *)( (char *)this + szindex2 ) : NULL;
	}
	inline char * const	pszNWayValueName( void ) const { return remaptype == FLEXCONTROLLER_REMAP_NWAY ? pNWayValueController()->pszName() : NULL; }
	inline int			nWayValueIndex( const CStudioHdr &cStudioHdr ) const;
	// Number of controllers this ui description contains, 1, 2 or 3
	inline int			Count() const { return ( stereo ? 2 : 1 ) + ( remaptype == FLEXCONTROLLER_REMAP_NWAY ? 1 : 0 ); }
	inline const mstudioflexcontroller_t *pController( int index ) const;
	 */

}
